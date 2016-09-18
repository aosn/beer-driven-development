# -*- coding: utf-8 -*-
__author__ = 'aosn'

from flask import Flask, request, jsonify
import random
import json
from data.entity import Player, Board, Cell

app = Flask(__name__)

# ゲーム開始時のデフォルト設定
players = []
current_player_id = -1
board = Board()
DEFAULT_CASH = 1500  # 開始時の資金$1500


@app.route("/")
def hello():
    return "Hello World!"


@app.route("bdd/game/<gameid>/state")
def handle_board_state():
    turn_str = "turn : " + str(current_player_id)
    players_str = "players : [ " + " , ".join( map( lambda p: p.toJson , get_players() ) ) + " ]"
    board_str = "board : " + board.toJson()
    result = "{ " + turn_str + " , " + players_str + ", " + board_str + " }"
    return jsonify(result)


@app.route("/bdd/game/<gameid>/change", methods=['PUT'])
def handle_board_change():
    """
    Received a request to change a state.
    :return: 204(No Content)
    """
    global players
    global current_player_id
    global board
    content_body_dict = json.loads(request.data)

    # turn
    current_player_id = content_body_dict["turn"]

    # players list
    players_list = content_body_dict["players"]
    players = tuple(map((lambda player_dict: Player(player_dict["id"], player_dict["name"], player_dict["position"], player_dict["cash"]),
                         players_list)))

    # board list
    board_dict = content_body_dict["board"]
    cells_dict = board_dict["cells"]
    board.cells = map(lambda cell_dict: Cell(cell_dict["id"], cell_dict["type"], cell_dict["owner"]), cells_dict)

    return 204


@app.route("/bdd/game/<gameid>/dice")
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
    app.run(host="0.0.0.0", port=50000)
