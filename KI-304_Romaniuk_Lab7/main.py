def main():
    try:
        # Запитуємо розмір квадратної матриці
        n = int(input("Enter the size of the square matrix : "))
        if n <= 0 or n % 2 == 0:
            raise ValueError("Matrix size must be positive integer.")
    except ValueError as e:
        print(f"Error: Invalid size value entered. {e}")
        return

    # Запитуємо символи-заповнювачі
    input_char1 = input("Enter the first placeholder character: ")
    input_char2 = input("Enter the second placeholder character: ")
    if len(input_char1) != 1 or len(input_char2) != 1:
        print("Error: symbol must be a single character.")
        return

    filler1 = input_char1[0]
    filler2 = input_char2[0]

    # Створення зубчастого масиву
    jagged_array = []
    for i in range(n // 2 + 1):

        if i <= n // 4:
            row = [filler1] * (n - 2 * i)

        else:
            row = [filler2] * (n - 2 * i)
        jagged_array.append(row)

    # Виведення зубчастого масиву
    print_jagged_array(jagged_array)

def print_jagged_array(jagged_array):
    """
    Виводить зубчастий масив на екран з відступами.
    """
    for i, row in enumerate(jagged_array):
        print("  " * i, end="")  # Відступи для кожного рядка
        print(" ".join(row))

if __name__ == "__main__":
    main()
