package com.mpp.javaproject.swimmasterjfx.repository;

import com.mpp.javaproject.swimmasterjfx.utils.JdbcUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class CompetitionDbRepository implements ICompetitionRepository{

    private JdbcUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();

    public CompetitionDbRepository(Properties props) {
        logger.info("Initializing CompetitionDbRepository with properties: {}", props);
        this.dbUtils = new JdbcUtils(props);
    }

    @Override
    public Object getOne(Object id) {
        return null;
    }

    @Override
    public Iterable getAll() {
        return null;
    }

    @Override
    public Object store(Object entity) {
        return null;
    }

    @Override
    public Object delete(Object id) {
        return null;
    }

    @Override
    public Object update(Object entity) {
        return null;
    }
}
