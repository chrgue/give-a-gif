var path = require('path');
var webpack = require('webpack');

module.exports = {
  entry: {
	  server: './src/main/resources/static/jsx/render-server.jsx',
	  client: './src/main/resources/static/jsx/render-client.jsx',
  },
  output: { path: './target/classes/static/js', filename: '[name].app.js' },
  module: {
    loaders: [
      {
        test: /.jsx?$/,
        loader: 'babel-loader',
        exclude: /node_modules/,
        query: {
          presets: ['es2015', 'react']
        }
      }
    ]
  },
};