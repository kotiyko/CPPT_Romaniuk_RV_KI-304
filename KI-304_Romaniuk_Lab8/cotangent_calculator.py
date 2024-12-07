import math

class CotangentCalculator:
    """
    Клас для обчислення виразу y = cot(8x) / x.
    """

    def calculate(self, x):
        """
        Обчислює вираз y = cot(8x) / x.

        """
        if x == 0:
            raise ArithmeticError("Поділ на нуль!")
        return 1 / math.tan(8 * x) / x
