package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.entity.ShippingOffer;

/**
 *
 * @author Loïc
 */
public class ShippingOfferDAO implements DAO<ShippingOffer, Long>{

    public final String TABLE_SHIPPING_OFFER = "SHIPPING_OFFER";
    
    public final String COLUMN_SHIPPING_OFFER_ID = "SHIPPING_OFFER_ID";
    public final String COLUMN_SHIPPING_OFFER_NAME = "SHIPPING_OFFER_NAME";
    public final String COLUMN_SHIPPING_OFFER_CONDITIONS = "SHIPPING_OFFER_CONDITIONS";
    public final String COLUMN_SHIPPING_OFFER_DETAILS = "SHIPPING_OFFER_DETAILS";
    public final String COLUMN_SHIPPING_OFFER_HT_PRICE = "SHIPPING_OFFER_HT_PRICE";
    
    // ID of the generic carrier into the database ( may vary )
    public final long GENERIC_CARRIER_ID = 5;
    
    public final String QUERY_SELECT_ALL_SHIPPING_OFFER
            = "SELECT * FROM " + TABLE_SHIPPING_OFFER;
    public final String QUERY_SELECT_SHIPPING_OFFER_BY_ID
            = "SELECT * FROM " + TABLE_SHIPPING_OFFER + " " 
            + "WHERE SHIPPING_OFFER_ID = ?";

    public final String QUERY_SELECT_SHIPPING_OFFER_BY_CARRIER
            = "SELECT * FROM " + TABLE_SHIPPING_OFFER + " " 
            + "WHERE CARRIER_ID = ?";

    @Override
    public void add(ShippingOffer object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ShippingOffer object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ShippingOffer object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<ShippingOffer> getAll() throws Exception {
        
        List<ShippingOffer> shippingOfferList = new ArrayList();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ALL_SHIPPING_OFFER);
        resultSet = statement.executeQuery();
        
        ShippingOffer shippingOffer = null;
        
        while (resultSet.next()) {

            shippingOffer = new ShippingOffer(
                    resultSet.getLong(COLUMN_SHIPPING_OFFER_ID),
                    resultSet.getString(COLUMN_SHIPPING_OFFER_NAME),
                    resultSet.getString(COLUMN_SHIPPING_OFFER_CONDITIONS),
                    resultSet.getDouble(COLUMN_SHIPPING_OFFER_HT_PRICE)
            );
            shippingOffer.setShippingOfferDetails(resultSet.getString(COLUMN_SHIPPING_OFFER_DETAILS));
            shippingOfferList.add(shippingOffer);
        }

        return shippingOfferList;
    }
    
    public List<ShippingOffer> getByCarrierId(Long id) throws NamingException, SQLException {
        
        List<ShippingOffer> shippingOfferList = new ArrayList();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_SHIPPING_OFFER_BY_CARRIER);
        statement.setLong(1, GENERIC_CARRIER_ID);
        resultSet = statement.executeQuery();
        
        ShippingOffer shippingOffer = null;
        
        
        while (resultSet.next()) {

            shippingOffer = new ShippingOffer(
                    resultSet.getLong(COLUMN_SHIPPING_OFFER_ID),
                    resultSet.getString(COLUMN_SHIPPING_OFFER_NAME),
                    resultSet.getString(COLUMN_SHIPPING_OFFER_CONDITIONS),
                    resultSet.getDouble(COLUMN_SHIPPING_OFFER_HT_PRICE)
            );
            shippingOffer.setShippingOfferDetails(resultSet.getString(COLUMN_SHIPPING_OFFER_DETAILS));
            shippingOfferList.add(shippingOffer);
        }

        return shippingOfferList;
    }
    
    @Override
    public ShippingOffer getById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}