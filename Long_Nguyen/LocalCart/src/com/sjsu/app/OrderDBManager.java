package com.sjsu.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.cap.UnresolvedConflictException;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;
import com.sjsu.model.*;

public class OrderDBManager {
	private RiakClient riak;
	private String database;
	private int port;
	private List<String> nodes;
	private static int ORDER_NUM_GENERATOR = 0;

	public OrderDBManager() {
		nodes = new LinkedList<String>();

		initDBConf();

		try {
			riak = RiakClient.newClient(port, nodes);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initDBConf() {
		// TODO Auto-generated method stub
		// Properties prop = new Properties();
		// InputStream input = null;
		// String configPath = "/Users/longnguyen/riak.conf";
		// System.out.println("config path: " + configPath);
		// try {
		//
		// input = new FileInputStream(configPath);
		//
		// // load a properties file
		// prop.load(input);
		// // int numOfNode =
		// // Integer.parseInt(prop.getProperty("num_of_node"));
		// // System.out.println("num_of_node = " + numOfNode);
		//
		// String riakIps = prop.getProperty("riak_ips");
		// String[] ips = null;
		// if (riakIps != null) {
		// ips = riakIps.split(",");
		// }
		// if (ips != null) {
		// for (String s : ips) {
		// System.out.println("riak_ip = " + s);
		// nodes.add(s);
		// }
		// }
		//
		// database = prop.getProperty("order_database");
		// System.out.println("database = " + database);
		// port = Integer.parseInt(prop.getProperty("port"));
		// System.out.println("port = " + port);
		// } catch (IOException ex) {
		// ex.printStackTrace();
		// }
		nodes.add("54.191.155.252");
		database = "order";
		port = 8087;
	}

	public OrderList getOrderList(String userId) {
		OrderList orderList = null;
		System.out.println("Request get OrderList, userId: " + userId);
		Location location = new Location(new Namespace(database), userId);
		FetchValue fv = new FetchValue.Builder(location).build();
		FetchValue.Response response;
		try {
			response = riak.execute(fv);
			orderList = response.getValue(OrderList.class);
			if (orderList == null) {
				orderList = new OrderList();
				orderList.setUserId(userId);
			}
		} catch (UnresolvedConflictException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Response get OrderList, userId: " + userId
				+ " orderList: "
				+ (orderList == null ? "null" : orderList.toString()));
		return orderList;
	}

	public void addOrder(Order order, String userId) {
		System.out.println("Request add Order, userId: " + userId);
		Location location = new Location(new Namespace(database), userId);
		OrderList orderList = getOrderList(userId);
		try {
			orderList.getOrders().add(order);
			StoreValue sv = new StoreValue.Builder(orderList).withLocation(
					location).build();
			StoreValue.Response svResponse = riak.execute(sv);
			System.out.println("Response store OrderList, userId: " + userId
					+ " svResponse: " + svResponse);
		} catch (UnresolvedConflictException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Order createOrder(Cart cart) {
		Order order = new Order();
		order.setOrderNum(String.valueOf(++ORDER_NUM_GENERATOR));
		// set date
		java.util.Date dNow = new java.util.Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
		order.setOrderDate("" + ft.format(dNow));

		order.setTotal(cart.getTotal());

		order.setItems(cart.getItemList());

		return order;
	}

	public Order getOrder(String userId, String orderNum) {
		Order order = null;
		OrderList orderList = getOrderList(userId);
		for (Order orderDB : orderList.getOrders()) {
			if (orderDB.getOrderNum().equals(orderNum)) {
				order = orderDB;
				break;
			}
		}
		return order;
	}

}
