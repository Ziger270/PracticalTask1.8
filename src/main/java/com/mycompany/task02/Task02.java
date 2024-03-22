package com.mycompany.task02;

import java.util.Collections;
import java.util.Scanner;
import java.util.LinkedList;

public class Task02 {
    
    public static boolean ContainsNum(LinkedList<Doctor> list, int num) {
        for (var el : list){
            if (el.num == num) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        var list = new LinkedList<Doctor>();
        
        list.add(new Doctor("Фёдоров Алексей Михайлович", "Хирург", 25, 20, true));
        list.add(new Doctor("Пропер Владимир Олегович", "Терапевт", 10, 120, true));
        list.add(new Doctor("Абрамов Валентин Михайлович", "Стоматолог", 1, 50, true));
        
        System.out.println("Вариант 3. Бисиров Александр Васильевич.");
        
        int command = 0;
        do {
            System.out.println("Выберите операцию:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить нового сотруднка");
            System.out.println("2. Вывести список сотрудников");
            
            command = scan.nextInt();
            
            switch (command){
                case 0: break;
                case 1: {
                    System.out.println("Введите ФИО сотрудника:");
                    String fio = scan.next();
                    System.out.println("Введите специальность сотрудника:");
                    String spec = scan.next();
                    int num;
                    do {
                        System.out.println("Введите порядковый номер сотрудника в списке:");
                        num = scan.nextInt();
                        if (ContainsNum(list, num))
                            System.out.println("Сотрудник с указанным порядковым номером уже существует в базе.");
                    } while(ContainsNum(list, num));
                    System.out.println("Введите количество рабочих смен сотрудника в месяц:");
                    int hours = scan.nextInt();
                    System.out.println("Сотрудник прошел аттестацию? (true/false):");
                    boolean attest = scan.nextBoolean();
                    
                    list.add(new Doctor(fio, spec, num, hours, attest));
                    break;
                }
                case 2: {
                    
                    Collections.sort(list);
                    for (var el : list) {
                        System.out.println("%s, %s, %s, %s, %s".formatted(el.FIO, el.specialty, el.num, el.hours, el.attestation));
                    }
                    
                    break;
                }
                default: {
                    System.out.println("Неверная операция!");
                }
            }
        } while (command != 0);
    }
}
