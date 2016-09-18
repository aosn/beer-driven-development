# -*- coding: utf-8 -*-
import json

class Player:
    def __init__(self, id_, name_, position_, cash_):
        self.id = id_
        self.name = name_
        self.position = position_
        self.cash = cash_

    def toJson(self):
        return json.dumps(self)

class Cell:
    def __init__(self, id_, type_, owner_):
        self.id = id_
        self.type = type_
        self.owner = owner_

    def toJson(self):
        return json.dumps(self)


class Board:
    _instance = None
    def __init__(self):
        self.cells = list()

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
        return cls._instance

    def toJson(self):
        return json.dumps(self)
