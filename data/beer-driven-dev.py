# -*- coding: utf-8 -*-
__author__ = 'aosn'

from flask import Flask
import random
app = Flask(__name__)


@app.route("/")
def hello():
    return "Hello World!"


@app.route("/bdd/game/1/change", methods='PUT')
def handle_board_change():

    return""




@app.route("/bdd/game/1/dice")
def handle_dice():
    die1 = random.randint(1, 6)
    die2 = random.randint(1, 6)
    return "{dice:["+str(die1)+","+str(die2)+"]}"

if __name__ == "__main__":
    app.run()