# -*- coding: utf-8 -*-
__author__ = 'aosn'

from flask import Flask, request
import random
from entity import Player

app = Flask(__name__)


# ゲーム開始時のデフォルト設定
players = []
DEFAULT_CASH = 1500     # 開始時の資金$1500

@app.route("/")
def hello():
    return "Hello World!"


@app.route("/bdd/game/1/dice")
def handle_dice():
    die1 = random.randint(1, 6)
    die2 = random.randint(1, 6)
    return "{dice:["+str(die1)+","+str(die2)+"]}"


@app.route("/bdd/game/new", methods = ["PUT"])
def handle_new():
    global players
    joined_names = request.args.get("username", "")

    names = joined_names.split(",")
    players = tuple(map(lambda name, user_id: Player(name, user_id, 0, DEFAULT_CASH), names, range(1, names.length)))

    return 0 #gameid


def get_players():
    global players
    return players


if __name__ == "__main__":
    app.run()
