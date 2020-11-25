from flask import Flask, request, jsonify
import webscrapDouglas as data

app = Flask(__name__)

@app.route('/')
def index():
    data.initialize()
    return getCourses()

@app.route('/courses/')
def getCourses():
    return jsonify(data.getCourses())

@app.route('/courses/<id>')
def getCourse(id):
    return jsonify(data.getCourse(id))