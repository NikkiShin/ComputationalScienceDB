var express = require('express');
var router = express.Router();
var client = require('mongodb').MongoClient;

router.post('/',function(req,res,next){

	var outputarray = new Array();
	var query = {};
	var items_array = new Array();
	
	client.connect('mongodb://203.153.146.39/metadata', function(err,db){
		
		db.collection("kflow").find().toArray(function(err, result){

			for(var i in result[0].output){
				outputarray[i] = JSON.stringify(result[0].output[i].name);
				outputarray[i] = outputarray[i].substring(1,outputarray[i].length-1);
			}			

		})
		
	})

	client.connect('mongodb://203.153.146.39/simulation', function(err,db){

		if (req.body.Grid != "")
		{
			query['input.Grid']=req.body.Grid;
		}
		if (req.body.Umach != "")
		{
			query['input.Umach']=req.body.Umach;
		}
		if (req.body.AOA != "")
		{
			query['input.AOA']=req.body.AOA;
		}
		if (req.body.RE != "")
		{
			query['input.RE']=req.body.RE;
		}
		if (req.body.IVISC != "")
		{
			query['input.IVISC']=req.body.IVISC;
		}
		if (req.body.rho_inf != "")
		{
			query['input.rho_inf']=req.body.rho_inf;
		}
		if (req.body.t_inf != "")
		{
			query['input.t_inf']=req.body.t_inf;
		}
		if (req.body.p_inf != "")
		{
			query['input.p_inf']=req.body.p_inf;
		}
		if (req.body.t_wall != "")
		{
			query['input.t_wall']=req.body.t_wall;
		}
		if (req.body.intensity != "")
		{
			query['input.intensity']=req.body.intensity;
		}
		if (req.body.f_func != "")
		{
			query['input.f_func']=req.body.f_func;
		}
		if (req.body.f_order != "")
		{
			query['input.f_order']=req.body.f_order;
		}
		if (req.body.limiter != "")
		{
			query['input.limiter']=req.body.limiter;
		}

		var cursor = db.collection("kflow").find(query);

		cursor.nextObject(function(err, items){

			items_array.push(items.output.aerodynamic.Cl, items.output.aerodynamic.Cdt, items.output.aerodynamic.Cdp, items.output.aerodynamic.Cdf, items.output.aerodynamic.Cm);

			items_array.push(items.output.field.flo001, items.output.field.flo002, items.output.field.flo003, items.output.field.flo004, items.output.field.flo005,
				items.output.field.flo006, items.output.field.flo007, items.output.field.flo008, items.output.field.flo009, items.output.field.flo010,
				items.output.field.flo011, items.output.field.flo012, items.output.field.flo013, items.output.field.flo014, items.output.field.flo015, 
				items.output.field.flo016);

			items_array.push(items.output.surface.sur002, items.output.surface.sur003, items.output.surface.sur004, items.output.surface.sur005,
				items.output.surface.sur006, items.output.surface.sur007);

			res.render('kflow_output',{outputarray:outputarray, items_array:items_array});

		})
		
	})

	

});


module.exports = router;
