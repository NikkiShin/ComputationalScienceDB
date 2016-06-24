var express = require('express');
var router = express.Router();
var client = require('mongodb').MongoClient;

router.post('/',function(req,res,next){
	
	client.connect('mongodb://203.153.146.39/simulation', function(err,db){

		var result = "";

		var query = {};

		if (req.body.aa != "")
		{
			query['input.aa']=req.body.aa;
		}
		if (req.body.bb != "")
		{
			query['input.bb']=req.body.bb;
		}
		if (req.body.cc != "")
		{
			query['input.cc']=req.body.cc;
		}
		if (req.body.dd != "")
		{
			query['input.dd']=req.body.dd;
		}
		if (req.body.ee != "")
		{
			query['input.ee']=req.body.ee;
		}
		

		var cursor = db.collection("simulation2").find(query);

		cursor.nextObject(function(err, items){

			res.render('simulation2_output',{items:items});

		})
		
	})

});


module.exports = router;
