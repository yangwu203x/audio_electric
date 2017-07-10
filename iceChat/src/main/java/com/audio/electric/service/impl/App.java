package com.audio.electric.service.impl;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Date;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/19 0019 9:17
 */
public class App {
    public static void main(String[] args) {

        try {

            /**** Connect to MongoDB ****/
            // Since 2.10.0, uses MongoClient
            MongoClient mongo = new MongoClient("localhost", 27017);

//            Mongo mongo = new Mongo("127.0.0.1",27017);


            /**** Get database ****/
            // if database doesn't exists, MongoDB will create it for you
            DB db = mongo.getDB("test");
            //database username  root  and password root
//            if(ok){
//                System.out.println("db connection success！");
//
//            }{
//                System.out.println("db connection fail ！");
//            }
            /**** Get collection / table from 'testMongoDb' ****/
            // if collection doesn't exists, MongoDB will create it for you
            DBCollection table = db.getCollection("message");

            /**** Insert ****/
            // create a document to store key and value
            BasicDBObject document = new BasicDBObject();
            document.put("msg", "聊天消息");
            document.put("srcUserId", 1);
            document.put("toUserId",2);
            document.put("context","回来吃饭");
            document.put("createdDate", new Date());
            table.insert(document);

            /**** Find and display ****/
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("toUserId", "2");

            DBCursor cursor = table.find(searchQuery);

            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

            /**** Update ****/
            // search document where name="mkyong" and update it with new values
            BasicDBObject query = new BasicDBObject();
            query.put("srcUserId", "1");

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("context", "什么时候回来？");

            BasicDBObject updateObj = new BasicDBObject();
            updateObj.put("$set", newDocument);

            table.update(query, updateObj);

            /**** Find and display ****/
            BasicDBObject searchQuery2
                    = new BasicDBObject().append("srcUserId", "1");

            DBCursor cursor2 = table.find(searchQuery2);

            while (cursor2.hasNext()) {
                System.out.println(cursor2.next());
            }

            /**** Done ****/
            System.out.println("Done");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }

    }
}
