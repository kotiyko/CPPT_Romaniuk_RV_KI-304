from cotangent_calculator import CotangentCalculator
from result_file_handler import ResultFileHandler
def main():
    """
    Основна функція програми. Обчислює вираз, записує та читає результати у файли.
    """
    calculator = CotangentCalculator()
    file_handler = ResultFileHandler()

    x = 0.5  # Значення
    try:
        # Обчислення результату
        result = calculator.calculate(x)
        print(f"Розрахований результат: {result}")

        # Шляхи до файлів
        text_file_path = "result.txt"
        binary_file_path = "result.bin"

        # Запис у текстовий файл
        file_handler.write_to_text_file(result, text_file_path)
        print("Результат записано у текстовий файл.")

        # Зчитування з текстового файлу
        text_result = file_handler.read_from_text_file(text_file_path)
        print(f"Результат з текстового файлу: {text_result}")

        # Запис у двійковий файл
        file_handler.write_to_binary_file(result, binary_file_path)
        print("Результат записано у двійковий файл.")

        # Зчитування з двійкового файлу
        binary_result = file_handler.read_from_binary_file(binary_file_path)
        print(f"Результат з двійкового файлу: {binary_result}")

    except ArithmeticError as e:
        print(f"Помилка обчислення: {e}")
    except IOError as e:
        print(f"Помилка роботи з файлом: {e}")

if __name__ == "__main__":
    main()