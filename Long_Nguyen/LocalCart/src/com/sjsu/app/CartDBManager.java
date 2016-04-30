package com.sjsu.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.ExecutionException;

import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.cap.UnresolvedConflictException;
import com.basho.riak.client.api.commands.kv.DeleteValue;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;
import com.sjsu.model.*;

public class CartDBManager {

	RiakClient riak;
	String database;
	int port;
	List<String> nodes;

	public CartDBManager() {
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
		// database = prop.getProperty("cart_database");
		// System.out.println("database = " + database);
		// port = Integer.parseInt(prop.getProperty("port"));
		// System.out.println("port = " + port);
		// } catch (IOException ex) {
		// ex.printStackTrace();
		// }
		nodes.add("54.191.155.252");
		database = "cart";
		port = 8087;
	}

	public Cart getCart(String userId) {
		Cart cart = null;
		System.out.println("Request get Cart, userId: " + userId);
		Location location = new Location(new Namespace(database), userId);
		FetchValue fv = new FetchValue.Builder(location).build();
		FetchValue.Response response;
		try {
			response = riak.execute(fv);
			cart = response.getValue(Cart.class);
			if (cart == null) {
				cart = new Cart();
				cart.setUserId(userId);
				storeCart(cart);
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

		cart.computeTotal();

		System.out.println("Response get Cart, userId: " + userId + " cart: "
				+ (cart == null ? "null" : cart.toString()));
		return cart;
	}

	public void storeCart(Cart cart) {
		System.out.println("Request store Cart, userId: " + cart.getUserId());
		Location location = new Location(new Namespace(database),
				cart.getUserId());
		StoreValue sv = new StoreValue.Builder(cart).withLocation(location)
				.build();
		try {
			StoreValue.Response svResponse = riak.execute(sv);
			System.out.println("Response store Cart, userId: "
					+ cart.getUserId() + " svResponse: " + svResponse);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteCart(String userId) {
		System.out.println("Request delete Cart, userId: " + userId);
		Location location = new Location(new Namespace(database), userId);
		DeleteValue delete = new DeleteValue.Builder(location).build();
		try {
			riak.execute(delete);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Cart addCartItem(String userId, CartItem item) {
		System.out.println("Request add CartItem, userId: " + userId);
		Cart cart = null;
		// get the Cart from DB
		cart = getCart(userId);
		if (cart == null) {
			cart = new Cart();
			cart.setUserId(userId);
		}
		System.out.println("Cart in DB before update, userId: " + userId
				+ " Cart: " + cart.toString());
		List<CartItem> dbItems = cart.getItemList();

		boolean isContain = false;
		for (CartItem dbItem : dbItems) {
			if (item.getId().equals(dbItem.getId())) {
				isContain = true;
				dbItem.setQuantity(dbItem.getQuantity() + item.getQuantity());
				dbItem.setTotalPrice(dbItem.getItemPrice()
						* dbItem.getQuantity());
			}
		}
		if (!isContain) {
			item.setTotalPrice(item.getItemPrice() * item.getQuantity());
			dbItems.add(item);
		}
		// re-compute the Total
		cart.computeTotal();
		// store the Cart to DB again
		storeCart(cart);
		System.out.println("Cart in DB after update, userId: " + userId
				+ " Cart: " + cart.toString());
		return cart;
	}

	public Cart releaseCartItem(String userId, CartItem item) {
		System.out.println("Request release CartItem, userId: " + userId);
		Cart cart = null;
		// get the Cart from DB
		cart = getCart(userId);
		if (cart == null) {
			System.out.println("ERROR: remove item in an empty Cart!!!");
			return cart;
		}
		System.out.println("Cart in DB before update, userId: " + userId
				+ " Cart: " + cart.toString());
		List<CartItem> dbItems = cart.getItemList();
		for (CartItem dbItem : dbItems) {
			if (item.getId().equals(dbItem.getId())) {
				dbItem.setQuantity(dbItem.getQuantity() - item.getQuantity());
				if (dbItem.getQuantity() <= 0) {
					dbItems.remove(dbItem);
				}
				break;
			}
		}
		// store the Cart to DB again
		storeCart(cart);
		System.out.println("Cart in DB after update, userId: " + userId
				+ " Cart: " + cart.toString());
		return cart;
	}

}