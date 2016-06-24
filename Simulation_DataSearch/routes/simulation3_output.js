var express = require('express');
var router = express.Router();
var client = require('mongodb').MongoClient;

router.post('/',function(req,res,next){
	
	client.connect('mongodb://203.153.146.39/simulation', function(err,db){

		var result = "";

		var query = {};

		if (req.body.AA != "")
		{
			query['input.AA']=req.body.AA;
		}
		if (req.body.BB != "")
		{
			query['input.BB']=req.body.BB;
		}
		if (req.body.CC != "")
		{
			query['input.CC']=req.body.CC;
		}
		if (req.body.DD != "")
		{
			query['input.DD']=req.body.DD;
		}
		if (req.body.EE != "")
		{
			query['input.EE']=req.body.EE;
		}
		

		var cursor = db.collection("simulation3").find(query);

		cursor.nextObject(function(err, items){

			res.render('simulation3_output',{items:items});

		})
		
	})

});


module.exports = router;
