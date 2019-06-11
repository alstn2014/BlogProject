package com.javablog.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javablog.exception.DeleteFailException;
import com.javablog.exception.EditFailException;
import com.javablog.exception.RegistFailException;
import com.javablog.model.domain.Board;
import com.javablog.model.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
   
   @Autowired
   private BoardDAO boardDAO;
 
   // ������ : �Խù� �Ѱ� ����ϱ�
   public void insert(Board board) throws RegistFailException{ 
         int result=boardDAO.insert(board);
        if(result==0 ) { 
         throw new RegistFailException("�Խù� ��� ����");
      }
   }

   // ������: �Խù� ����
      public void update(Board board) throws EditFailException{
         int result=boardDAO.update(board);
         if(result==0 ) {
            throw new EditFailException("�Խù� ���� ����");
         }
      }
   
   // ������: �Խù� ����
      public void delete(int board_id) throws DeleteFailException{
		int result=boardDAO.delete(board_id);
		if(result==0) {
		  throw new DeleteFailException("���� ����");
		}
      }
   
   // ������: �Խù� ��� ����
   public List selectAll() {
      return boardDAO.selectAll();
   }
   
   // ������: �Ծ� �Խù� 1�� �󼼺���
   public Board select(int board_id) {
      return boardDAO.select(board_id);
   }
   
}