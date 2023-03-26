package com.mpp.javaproject.swimmasterjfx.repository.operator;

import com.mpp.javaproject.swimmasterjfx.domain.Operator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mpp.javaproject.swimmasterjfx.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OperatorsDbRepository implements IOperatorsRepository{
    private JdbcUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();

    public OperatorsDbRepository(Properties props) {
        logger.info("Initializing OperatorsDBRepository with properties: {}", props);
        this.dbUtils = new JdbcUtils(props);
    }

    @Override
    public Operator getOne(Integer id) {
        logger.traceEntry("extracting operator with id {}", id);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preparedStatement = con.prepareStatement("select * from operators where id=?")){
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()) {
                int oid = result.getInt("id");
                String username = result.getString("username");
                String password = result.getString("password");

                Operator operator = new Operator(username, password);
                operator.setId(oid);
                logger.traceExit();
                return operator;
            }
        }catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        return null;
    }

    @Override
    public Operator getOneByUsername(String username) {
        logger.traceEntry("extracting operator with username {}", username);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preparedStatement = con.prepareStatement("select * from operators where username=?")){
            preparedStatement.setString(1,username);
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()) {
                int id = result.getInt("id");
                String oUsername = result.getString("username");
                String password = result.getString("password");

                Operator operator = new Operator(oUsername, password);
                operator.setId(id);
                logger.traceExit();
                return operator;
            }
        }catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        return null;
    }

    @Override
    public Iterable<Operator> getAll() {
        logger.traceEntry("extracting operators");
        Connection con = dbUtils.getConnection();
        List<Operator> operators = new ArrayList<>();
        try(PreparedStatement preparedStatement = con.prepareStatement("select * from operators")){
            try(ResultSet result = preparedStatement.executeQuery()) {
                while (result.next()){
                    int id = result.getInt("id");
                    String username = result.getString("username");
                    String password = result.getString("password");

                    Operator operator = new Operator(username, password);
                    operator.setId(id);
                    operators.add(operator);
                }
            }
        }catch (SQLException ex){
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }
        logger.traceExit();
        return operators;
    }

    @Override
    public Operator store(Operator entity) {
        logger.traceEntry("saving operator {} ", entity);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preparedStatement = con.prepareStatement("insert into operators (username, password) values (?,?)")){
            preparedStatement.setString(1, entity.getUsername());
            preparedStatement.setString(2, entity.getPassword());

            int result=preparedStatement.executeUpdate();
            logger.trace("Saved {} instances", result);
        }catch (SQLException ex){
            logger.error(ex);
            System.err.println("Error DB "+ex);
            return entity;
        }
        logger.traceExit();
        return null;
    }

    @Override
    public Operator delete(Integer id) {
        logger.traceEntry("deleting operator {} ", id);
        Connection con = dbUtils.getConnection();

        try(PreparedStatement preparedStatement = con.prepareStatement("delete from operators where id=?")){
            Operator operator = getOne(id);
            preparedStatement.setInt(1, id);

            int result=preparedStatement.executeUpdate();
            logger.trace("Operator {} deleted", result);
            return operator;
        }catch (SQLException ex){
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }
        logger.traceExit();
        return null;
    }

    @Override
    public Operator update(Operator entity) {
        return null;
    }
}
