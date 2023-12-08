from flask import Flask, render_template, request, redirect, url_for
import requests
import os

app = Flask(__name__)

# Define api_url globally, with a default value
api_url = os.getenv('API_BASE_URL', 'http://localhost:8090')

@app.route('/')
def index():
    response = requests.get(f'{api_url}/api/strings')
    strings = response.json() if response.status_code == 200 else []
    return render_template('index.html', strings=strings)

@app.route('/string/<string>')
def show(string):
    response = requests.get(f'{api_url}/api/strings/{string}')
    string_detail = response.json() if response.status_code == 200 else {}
    return render_template('string_detail.html', string=string_detail)

@app.route('/string/<string>/edit', methods=['GET', 'POST'])
def edit(string):
    if request.method == 'GET':
        response = requests.get(f'{api_url}/api/strings/{string}')
        string_detail = response.json() if response.status_code == 200 else {}
        return render_template('edit_string.html', string=string_detail)

    elif request.method == 'POST':
        new_string = request.form.get('newString')
        response = requests.put(f'{api_url}/api/strings/{string}/{new_string}')
        # Handle response as needed
        return redirect(url_for('index'))

@app.route('/string/<string>/delete', methods=['GET', 'POST'])
def delete(string):
    if request.method == 'GET':
        return render_template('confirm_delete.html', string=string)

    elif request.method == 'POST':
        print(f'{api_url}/api/strings/{string}')  # Add debug print statement
        response = requests.delete(f'{api_url}/api/strings/{string}')
        # Handle response as needed
        return redirect(url_for('index'))

@app.route('/create', methods=['POST'])
def create():
    new_string = request.form.get('newString')
    response = requests.post(f'{api_url}/api/strings/{new_string}')
    # Handle response as needed
    return redirect(url_for('index'))

if __name__ == '__main__':
    app.run(debug=True)
