/*
Необходимо написать программу – розыгрыша игрушек в магазине детских товаров.
Стараемся применять ООП и работу с файлами.
В программе должен быть минимум один класс со следующими свойствами:
id игрушки,
текстовое название,
количество
частота выпадения игрушки (вес в % от 100)
 
Метод добавление новых игрушек и возможность изменения веса (частоты выпадения игрушки).
Возможность организовать розыгрыш игрушек.

Например, следующим образом:
С помощью метода выбора призовой игрушки – мы получаем эту призовую игрушку и записываем в список\массив.
Это список призовых игрушек, которые ожидают выдачи.
Еще у нас должен быть метод – получения призовой игрушки.
После его вызова – мы удаляем из списка\массива первую игрушку и сдвигаем массив. А эту игрушку записываем в текстовый файл.
Не забываем уменьшить количество игрушек.
 */

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Инициализируем магазин игрушек
        ToyShop toyShop = new ToyShop();

        // Добавляем игрушки в магазин
        toyShop.addToy(1, "Чебурашка", 10, 10);
        toyShop.addToy(2, "Щелкунчик", 15, 15);
        toyShop.addToy(3, "Капибара", 20, 25);
        toyShop.addToy(4, "Медвежонок", 10, 10);
        toyShop.addToy(5, "Трансформер", 15, 15);
        toyShop.addToy(6, "Кукла Маша", 20, 25);

        // Изменяем частоту выпадения игрушки
        toyShop.changeFrequency(1, 16);
        toyShop.changeFrequency(2, 17);
        toyShop.changeFrequency(3, 17);
        toyShop.changeFrequency(4, 16);
        toyShop.changeFrequency(5, 17);
        toyShop.changeFrequency(6, 17);

        while (toyShop.hasToys()) {
            // Запускаем розыгрышь игрушек
            toyShop.playGame();
            // Выводим призовую игрушку
            Toy prizeToy = toyShop.getPrizeToy();
            System.out.println("Призовая игрушка: Номер - " + prizeToy.getId() + ", Название - " + prizeToy.getName());
            System.out.println();
            System.out.print("Для продолжения введите Enter:");
            scanner.nextLine();
            System.out.println();
            // Выводим остатки игрушек
            toyShop.displayRemainingToys();
            System.out.println();
            System.out.print("Для продолжения введите Enter:");
            scanner.nextLine();
            System.out.println();
        }
        System.out.println("Игрушки закончились.");
        System.out.println();
    }
}
