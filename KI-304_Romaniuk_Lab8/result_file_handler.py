import struct

class ResultFileHandler:
    """
    Клас для роботи з текстовими та двійковими файлами.
    """

    def write_to_text_file(self, result, file_path):
        """
        Записує результат у текстовий файл.

        """
        try:
            with open(file_path, "w", encoding="utf-8") as file:
                file.write(f"Результат: {result}\n")
        except IOError as e:
            raise IOError(f"Помилка запису у файл {file_path}: {e}")

    def read_from_text_file(self, file_path):
        """
        Читає результат із текстового файлу.
        """
        try:
            with open(file_path, "r", encoding="utf-8") as file:
                line = file.readline()
                if line.startswith("Результат: "):
                    return float(line.split(": ")[1])
                else:
                    raise IOError("Некоректний формат даних у файлі.")
        except IOError as e:
            raise IOError(f"Помилка читання з файлу {file_path}: {e}")

    def write_to_binary_file(self, result, file_path):
        """
        Записує результат у двійковий файл.
        """
        try:
            with open(file_path, "wb") as file:
                file.write(struct.pack("d", result))  # "d" означає double
        except IOError as e:
            raise IOError(f"Помилка запису у файл {file_path}: {e}")

    def read_from_binary_file(self, file_path):
        """
        Читає результат із двійкового файлу.

        :param file_path: Шлях до файлу.
        :return: Зчитаний результат.
        :raises IOError: У випадку помилки читання.
        """
        try:
            with open(file_path, "rb") as file:
                return struct.unpack("d", file.read(8))[0]  # Читаємо double (8 байт)
        except IOError as e:
            raise IOError(f"Помилка читання з файлу {file_path}: {e}")
