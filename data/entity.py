# -*- coding: utf-8 -*-

class Player:
    def __init__(self, id_, name_, position_, cash_):
        self.id = id_
        self.name = name_
        self.position = position_
        self.cash = cash_

    def toJson(self):
        id_str =  "id : " + str(self.id)
        name_str = "name : " + self.name
        position_str = "position : " + str(self.position)
        cash_str = "cash : " + str(self.cash)
        return "{" + id_str + " , "+ name_str + " , "+ position_str + " , "+ cash_str + "}"

class Cell:
    def __init__(self, id_, type_, owner_):
        self.id = id_
        self.type = type_
        self.owner = owner_

    def toJson(self):
        id_str = "id : " + str(self.id)
        type_str = "type : " + str(self.type)
        owner_str = "owner : " + str(self.owner)
        return "{" + id_str + " , " + type_str + " , " + owner_str + " , " + "}"


class Board:
    _instance = None
    def __init__(self):
        self.cells = list()

    def __new__(cls):
        if cls.instance_ is None:
            cls._instance = super().__new__(cls)
        return cls._instance

    def toJson(self):
        cells_str = "cells_str : " + " , ".join( map( lambda c:c.toJson() , self.cells.toJson() ) )
        return "{ " + cells_str + " }"
