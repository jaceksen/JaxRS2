package pl.jaceksen.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pl.jaceksen.messenger.database.DatabaseClass;
import pl.jaceksen.messenger.model.Message;

public class MessageService {
	
	
	public MessageService() {
		messages.put(1L,new Message(1L, "Wiadomość 1", "Jacek"));
		messages.put(2L,new Message(2L, "Wiadomość 2", "Rima"));
	}

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	
	
	public List<Message> getAllMessages() {
		
//		Message m1 = new Message(1L, "Wiadomość 1", "Jacek");
//		Message m2 = new Message(2L, "Wiadomość 2", "Rima");
//		
//		List<Message> list = new ArrayList<>();
//		list.add(m1);
//		list.add(m2);
//		
//		return list;
		
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	
	
	
	
	

}
