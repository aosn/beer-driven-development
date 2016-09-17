# -*- coding: utf-8 -*-
__author__ = 'aosn'

from flask import Flask, request
import random
import json
from data.entity import Player
from data.entity import Board

app = Flask(__name__)


# ゲーム開始時のデフォルト設定
players = []
current_player_id = -1
board = Board()
DEFAULT_CASH = 1500  # 開始時の資金$1500


@app.route("/")
def hello():
    return "Hello World!"

@app.route("bdd/game/1/state")
def handle_board_state():
    turn_str = "turn : 0"
    players_str = "players : [ " + " , ".join( map( lambda p: p.toJson , get_players() ) ) + " ]"
    board_str = "board : " + Board.toJson()
    return "{ " + turn_str + " , " + players_str + ", " + board_str + " }"


@app.route("/bdd/game/1/change", methods=['PUT'])
def handle_board_change():
    """
    Received a request to change a state.
    :return: 204(No Content)
    """
    global board
    content_body_dict = json.loads(request.data)
    board_dict = content_body_dict["board"]
    cells_dict = board_dict["cells"]
    for cell_dict in cells_dict:
        cell_id = cell_dict["id"]
        type_dict = cell_dict["type"]
        # @TODO implement

    # change to next player

    return 204


@app.route("/bdd/game/1/dice")
def handle_dice():
    die1 = random.randint(1, 6)
    die2 = random.randint(1, 6)
    return "{dice:[" + str(die1) + "," + str(die2) + "]}"


@app.route("/bdd/game/new", methods=["PUT"])
def handle_new():
    """
     Received a request to begin a game.
    :return: game id
    """
    global players
    content_body_dict = json.loads(request.data)
    names = content_body_dict["users"]
    players = tuple(map(lambda name, user_id: Player(name, user_id, 0, DEFAULT_CASH), names, range(1, names.length)))

    return 0


def get_players():
    """
    Return Players instance.
    :return: Player tuple instance
    """
    global players
    return players

if __name__ == "__main__":
    app.run()
