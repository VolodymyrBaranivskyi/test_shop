package com.volodymyrbaranivskyi.test_shop.data.dao.impl;

import com.volodymyrbaranivskyi.test_shop.data.dao.ProductDao;
import com.volodymyrbaranivskyi.test_shop.model.entities.PageRequest;
import com.volodymyrbaranivskyi.test_shop.model.entities.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static java.util.Objects.isNull;


@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl() {
    }

    @Override
    public List<Products> getAll(String regex) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createCriteria(Products.class, "shop_eva.products")
                .list();
    }

    @Override
    public Products save(Products product) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Products) session.merge(product);
    }

    public List<Products> getAllAvailable(PageRequest pageRequest) {
        String sql = "SELECT p.* " +
                "FROM shop_eva.Products p ";
        return generateQueryWithPagination(sql, pageRequest)
                .getResultList();
    }

    public List<Products> getAllAvailable() {
        Session session = this.sessionFactory.getCurrentSession();
        return session
                .createQuery(
                        "SELECT p " +
                                "FROM Products p ",
                        Products.class)
                .getResultList();
    }

    private Query<Products> generateQueryWithPagination(String sql, PageRequest pageRequest) {
        Session session = this.sessionFactory.getCurrentSession();
        if (isNull(pageRequest)) {
            return session.createNativeQuery(sql, Products.class);
        }

        StringBuilder builder = new StringBuilder(sql);

        return session.createNativeQuery(builder.toString(), Products.class)
                .setFirstResult(pageRequest.getOffset())
                .setMaxResults(pageRequest.getSize());
    }

}
