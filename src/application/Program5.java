package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program5 {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int lessons = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		for(int i=1; i <= lessons; i++) {
			System.out.print("Dados da "+ i + "a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char answer = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Título: ");
			String title = sc.nextLine();
			
			if(answer == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();			
				System.out.print("Duração em segundos: ");
				Integer seconds = sc.nextInt();		
				sc.nextLine();
				System.out.println();
				
				list.add(new Video(title, url, seconds));
			}
			else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();			
				System.out.print("Quantidade de questões: ");
				Integer questions = sc.nextInt();		
				sc.nextLine();
				System.out.println();
				
				list.add(new Task(title, description, questions));
			}
		}
		
		int totalDuration = 0;
		
		for(Lesson lesson : list) {
			totalDuration += lesson.duration();
		}
		
		System.out.print("DURAÇÃO TOTAL DO CURSO = " + totalDuration + " segundos");
		
		sc.close();
	}
}
