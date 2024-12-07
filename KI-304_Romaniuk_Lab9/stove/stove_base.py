class CookingStove:
    """
    Базовий клас для плитки для приготування їжі.
    """

    def __init__(self, brand, burners, power):
        """
        Ініціалізує базову плитку.

        :param brand: Бренд плитки.
        :param burners: Кількість конфорок.
        :param power: Потужність (кВт).
        """
        self.brand = brand
        self.burners = burners
        self.power = power

    def turn_on(self):
        """
        Увімкнення плитки.
        """
        return f"{self.brand} плитка увімкнена."

    def turn_off(self):
        """
        Вимкнення плитки.
        """
        return f"{self.brand} плитка вимкнена."

    def __str__(self):
        """
        Повертає інформацію про плитку.
        """
        return f"Бренд: {self.brand}, Конфорок: {self.burners}, Потужність: {self.power} кВт"
