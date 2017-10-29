'use strict';
module.exports = function(app) {
  var controller = require('../controllers/studentController');
  var film_controller = require("../controllers/filmController");

  // todoList Routes
  app.route('/students')
    .get(controller.list_students)
    .post(controller.create_student);


  app.route('/students/:id')
    .get(controller.read_student)
    .put(controller.update_student)
    .delete(controller.delete_student);
  
  app.route('/films')
    .get(film_controller.list_films)
  
};
