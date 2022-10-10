package com.example.RestNew.services;

import com.example.RestNew.Connection.ConnectionMaker;
import com.example.RestNew.entity.Scientist;
import com.example.RestNew.entity.ScientistList;
import org.springframework.stereotype.Service;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@Service
public class DaoOperationsImplementation implements DaoOperations {

    Connection connection = ConnectionMaker.getConnection();
    Statement statement;
    ResultSet resultSet;
    @Override
    public Scientist fetchScientistById(int id) {

        try {
            List<Scientist> scientists = new ArrayList<>();
            statement = connection.createStatement();
            ResultSet scientistResultSet = statement.executeQuery("select * from scientist where scientist_id = " + id);
            if (scientistResultSet.next()) {
                scientists = new ArrayList<>();
                Scientist scientist = new Scientist();
                int scientistId = scientistResultSet.getInt(1);
                scientist.setScientistId(scientistId);
                scientist.setScientistName(scientistResultSet.getString(2));
                scientist.setScientistDateOfBirth(scientistResultSet.getString(3));
                scientist.setScientistDateOfDeath(scientistResultSet.getString(4));
                scientist.setScientistProfilePicture(scientistResultSet.getString(5));
                scientist.setScientistBio(scientistResultSet.getString(6));
                scientist.setScientistEducation(scientistResultSet.getString(7));
                scientist.setScientistUniversity(scientistResultSet.getString(8));
                scientist.setScientistCountries(scientistResultSet.getString(9));
                scientist.setScientistFieldOfStudy(scientistResultSet.getString(10));

                Statement statement1 = connection.createStatement();
                ResultSet awardsSet = statement1.executeQuery("select * from awards where scientist_id = " + scientistId);
                List<String> awards = new ArrayList<>();
                while (awardsSet.next()) {
                    awards.add(awardsSet.getString(2));
                }
                scientist.setScientistAwards(awards);

                Statement statement2 = connection.createStatement();
                ResultSet inventionsSet = statement2.executeQuery("select * from inventions where scientist_id = " + scientistId);
                List<String> inventions = new ArrayList<>();
                while (inventionsSet.next()) {
                    inventions.add(inventionsSet.getString(2));
                }
                scientist.setScientistKnownFor(inventions);

                scientists.add(scientist);
                return scientist;

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public HashMap<String, List> fetchAllIdAndUsername() {

        HashMap<String, List> hashMap = new HashMap<>();

        try {

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from scientist");
            List<ScientistList> scientists = new ArrayList<>();
            while (resultSet.next()) {
                ScientistList scientistList = new ScientistList();
                int scientistId = resultSet.getInt(1);
                scientistList.setScientistId(scientistId);
                scientistList.setScientistName(resultSet.getString(2));
                scientists.add(scientistList);
            }
            hashMap.put("data", scientists);
            hashMap.put("error", null);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hashMap;
    }

    @Override
    public HashMap<String, List> invalidUrlException() {
        HashMap<String, List> hashMap = new HashMap<>();
        List<String> list= new ArrayList<>();
        list.add("Invalid URL");
        hashMap.put("data", null);
        hashMap.put("error", list);
        return hashMap;
    }
}
