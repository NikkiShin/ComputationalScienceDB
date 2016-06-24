var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var routes = require('./routes/index');
var users = require('./routes/users');
var home = require('./routes/home');
var kflow_input = require('./routes/kflow_input');
var kflow_output = require('./routes/kflow_output');
var download = require('./routes/download');
var simulation2_input = require('./routes/simulation2_input');
var simulation2_output = require('./routes/simulation2_output');
var simulation3_input = require('./routes/simulation3_input');
var simulation3_output = require('./routes/simulation3_output');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', routes);
app.use('/users', users);
app.use('/home', home);
app.use('/simulation2_input', simulation2_input);
app.use('/simulation2_output', simulation2_output);
app.use('/simulation3_input', simulation3_input);
app.use('/simulation3_output', simulation3_output);
app.use('/kflow_input', kflow_input);
app.use('/kflow_output', kflow_output);
app.use('/download', download);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handlers

// development error handler
// will print stacktrace
if (app.get('env') === 'development') {
  app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
      message: err.message,
      error: err
    });
  });
}

// production error handler
// no stacktraces leaked to user
app.use(function(err, req, res, next) {
  res.status(err.status || 500);
  res.render('error', {
    message: err.message,
    error: {}
  });
});


module.exports = app;
