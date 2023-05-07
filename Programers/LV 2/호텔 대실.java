import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        List<Room> rooms = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        for(String[] book : book_time)
            books.add(new Book(getTime(book[0]), getTime(book[1])));
        
        Collections.sort(books, (b1, b2) -> {
            return Integer.compare(b1.startTime, b2.startTime);
        });
        
        for(Book curBook : books) {
            //check can enter room exist
            boolean canEnter = false;
            for(Room room : rooms) {
                if(room.endTime <= curBook.startTime) {
                    canEnter = true;
                    room.endTime = curBook.endTime + 10;
                    break;
                }
            }
            if(!canEnter) 
                rooms.add(new Room(curBook.startTime, curBook.endTime + 10));
            
            // for(Room room : rooms) {
            //     System.out.print(room.toString() + " ");
            // }
            // System.out.println();
        }
        
        answer = rooms.size();
        return answer;
    }
    
    public int getTime(String time) {
        String[] splitedTime = time.split(":");
        return Integer.parseInt(splitedTime[0]) * 60 + 
            Integer.parseInt(splitedTime[1]);
    }
}

class Book {
    int startTime;
    int endTime;
    public Book(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class Room {
    int startTime;
    int endTime;
    public Room(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public String toString() {
        return "Room[startTime=" + String.valueOf(startTime) +
            " endTime=" + String.valueOf(endTime) + "]";
    }
}