var express = require('express');
var router = express.Router();
var url = require('url');

/* GET users listing. */
router.get('/', function(req, res, next) {
  var uri = url.parse(req.url, true);
  res.download(uri.query.path);
});

module.exports = router;
