package com.sjsu.couch.repository;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.Page;
import org.ektorp.PageRequest;
import org.ektorp.ViewQuery;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sjsu.couch.model.Item;

@Component
public class CatalogRepository extends CouchDbRepositorySupport<Item> {

	
	@Autowired
	public CatalogRepository(@Qualifier("shoppingCartDatabase") CouchDbConnector db) {
		super(Item.class, db);
		initStandardDesignDocument();
	}

	@GenerateView @Override
	public List<Item> getAll() {
		ViewQuery q = createQuery("all")
						.descending(true)
						.includeDocs(true);
		return db.queryView(q, Item.class);
	}
	
	public Page<Item> getAll(PageRequest pr) {
		ViewQuery q = createQuery("all")
						.descending(true)
						.includeDocs(true);
		return db.queryForPage(q, pr, Item.class);
	}
	
	
	
	
	
}
