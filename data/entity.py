# -*- coding: utf-8 -*-

class player:
    def __init__(self,id_ ,name_ ,position_, cash_):
        self.id = id_
        self.name = name_
        self.position = position_
        self.cash = cash_

    def toJson(self):
        return "{}"

class cell:
    def __init__(self,id_ , type_ , owner_ ):
        self.id = id_
        self.type = type_
        self.owner = owner_

    def toJson(self):
        return "{}"


class board:
    def __init__(self):
        self.cells = []
        # TODO celsの中身を作る


    def toJson(self):
        return "{}"