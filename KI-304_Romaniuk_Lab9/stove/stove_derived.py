from stove.stove_base import CookingStove

class ElectricCookingStove(CookingStove):
    """
    Похідний клас для електричної плитки.
    """

    def __init__(self, brand, burners, power, has_timer):
        """
        Ініціалізує електричну плитку.

        :param brand: Бренд плитки.
        :param burners: Кількість конфорок.
        :param power: Потужність (кВт).
        :param has_timer: Наявність таймера (True/False).
        """
        super().__init__(brand, burners, power)
        self.has_timer = has_timer

    def set_timer(self, minutes):
        """
        Встановлення таймера.

        :param minutes: Кількість хвилин для таймера.
        :return: Повідомлення про встановлення таймера.
        """
        if self.has_timer:
            return f"Таймер встановлено на {minutes} хвилин."
        else:
            return "Ця плитка не підтримує таймер."

    def __str__(self):
        """
        Повертає інформацію про електричну плитку.
        """
        base_info = super().__str__()
        timer_info = "є таймер" if self.has_timer else "немає таймера"
        return f"{base_info}, {timer_info}"
