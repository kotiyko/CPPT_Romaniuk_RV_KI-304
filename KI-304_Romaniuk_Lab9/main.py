from stove.stove_base import CookingStove
from stove.stove_derived import ElectricCookingStove


def main():

    # Створення об'єкта базового класу
    basic_stove = CookingStove(brand="Bosch", burners=4, power=3.5)
    print("Базова плитка:")
    print(basic_stove)
    print(basic_stove.turn_on())
    print(basic_stove.turn_off())
    print()

    # Створення об'єкта похідного класу
    electric_stove = ElectricCookingStove(brand="Samsung", burners=4, power=5.0, has_timer=True)
    print("Електрична плитка:")
    print(electric_stove)
    print(electric_stove.turn_on())
    print(electric_stove.set_timer(30))
    print(electric_stove.turn_off())

if __name__ == "__main__":
    main()
