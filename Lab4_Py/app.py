from flask import Flask
from flask import render_template
from flask import request

from flask_wtf import FlaskForm
from wtforms import SelectField,SubmitField
from wtforms.validators import DataRequired


base = 'http://up-lab2.mirea.ru/student/all'

import requests



def get_group_list():
    data = requests.get('http://up-lab2.mirea.ru/student/all').json()
    ans = []
    for i in data:
        ans.append(i['studyGroupId'])
    d = [(str(i),str(i)) for i in list(set(ans))]
    d = [('0','Все')] + d
    return d

"""
def get_group(id = None):
    data = []
    if not id or id=='0':
        data = requests.get("http://up-lab2.mirea.ru/student/all").json()
    else:
        try:
            data = requests.get("http://up-lab2.mirea.ru/student/all").json()
            d1 = [i for i in data if i["STUDY_GROUP_ID"]==id]
            data = d1
        except Exception as e:
            data = requests.get("http://up-lab2.mirea.ru/student/all").json()
    return data
"""
class SelectForm(FlaskForm):
    group = SelectField('Группа',choices=get_group_list())
    ok = SubmitField("Выбрать")


def get_group(id = None):
    data = requests.get(base).json()
    if not id or id=='0':
        return data
    else:
        try:
            return [i for i in data if i["studyGroupId"]==int(id)]
        except Exception as e:
            return data






app = Flask(__name__)
app.config['SECRET_KEY'] = 'you-will-never-guess'




class Select_Form(FlaskForm):

    group = SelectField('Группа',choices=get_group_list())
    ok = SubmitField("Выбрать")




@app.route('/',methods=['GET','POST'])
def students():
    form = Select_Form()
    data = None
    if (form.group.data!="None"):
        data = get_group(form.group.data)
    else:
        data = get_group()
    return render_template("index.html",students = data, form = form)

if __name__ == '__main__':
    app.run()
