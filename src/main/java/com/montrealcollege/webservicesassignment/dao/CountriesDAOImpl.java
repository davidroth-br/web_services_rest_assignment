package com.montrealcollege.webservicesassignment.dao;

import com.montrealcollege.webservicesassignment.model.Countries;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CountriesDAOImpl implements CountriesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCountry(Countries country) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(country);
        session.getTransaction().commit();
    }

    @Override
    public List<Countries> listCountries() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Countries> criteriaQuery = criteriaBuilder.createQuery(Countries.class);
        Root<Countries> root = criteriaQuery.from(Countries.class);
        criteriaQuery.select(root);

        Query<Countries> query = session.createQuery(criteriaQuery);
//        System.out.println(query.list().toString());
        return query.list();
    }
}
