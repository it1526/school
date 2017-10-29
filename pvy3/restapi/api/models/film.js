'use strict';
var db=require('../dbconnection'); //reference of dbconnection.js

var Film = {

getAll: function(callback){
    return db.query("Select * from film", callback);
}

};
module.exports=Film;