'use strict';

var mysql=require('mysql');

var connection = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "",
    database: "it3prog"
  });
  
module.exports = connection;