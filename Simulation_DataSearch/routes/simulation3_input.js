var express = require('express');
var router = express.Router();
var client = require('mongodb').MongoClient;

/* GET home page. */
router.get('/', function(req, res, next) {

  	client.connect('mongodb://203.153.146.39/metadata', function(err,db){

		var inputarray = new Array();

		db.collection('simulation3').find().toArray(function(err, result){
			

			for(var i in result[0].input){
				inputarray[i] = JSON.stringify(result[0].input[i].name);
				inputarray[i] = inputarray[i].substring(1,inputarray[i].length-1);
			}

			res.render('simulation3_input',{ title: 'Simulation3 Simulation Data Search', items:inputarray});
		})

	})
});

module.exports = router;
