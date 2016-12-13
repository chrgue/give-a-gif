var path = require('path');
var webpack = require('webpack');
var ExtractTextPlugin = require("extract-text-webpack-plugin");

module.exports = {
	entry : {
		server : './src/main/resources/static/jsx/render-server.jsx',
		client : './src/main/resources/static/jsx/render-client.jsx',
	},
	output : {
		path : './target/classes/static/',
		filename : 'js/[name].app.js'
	},
	module : {
		loaders : [
			{
				test : /.jsx?$/,
				loader : 'babel-loader',
				exclude : /node_modules/,
				query : {
					presets : [ 'es2015', 'react' ]
				}
			},
			{
				test : /\.eot(\?v=\d+\.\d+\.\d+)?$/,
				loader : 'file'
			},
			{
				test : /\.(woff|woff2)$/,
				loader : 'url?prefix=font/&limit=5000'
			},
			{
				test : /\.ttf(\?v=\d+\.\d+\.\d+)?$/,
				loader : 'url?limit=10000&mimetype=application/octet-stream'
			},
			{
				test : /\.svg(\?v=\d+\.\d+\.\d+)?$/,
				loader : 'url?limit=10000&mimetype=image/svg+xml'
			},
			// Extract css files
            {
                test: /\.css$/,
                loader: ExtractTextPlugin.extract("style-loader", "css-loader")
            }
		]
	},
	plugins : [
		// some libraries assuming jquery been defined globally (e.g. bootstrap js)  		
		new webpack.ProvidePlugin({
			jQuery : 'jquery',
			$: 'jquery'
		}),
		new ExtractTextPlugin("style/[name].css")
	]
};