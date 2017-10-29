'use strict';
var Film = require('../models/film'); //reference of dbconnection.js


exports.list_films = function(req, res) {
  Film.getAll(function(err, film) {
    if (err)
      res.send(err);
    res.json(film);
  });
};