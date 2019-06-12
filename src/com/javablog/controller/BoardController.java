package com.javablog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javablog.commons.Pager;
import com.javablog.model.domain.Board;
import com.javablog.model.service.BoardService;

@Controller
public class BoardController{

   @Autowired
   private BoardService boardService;
   
   private Pager pager=new Pager();
 
 //�Խù� ��Ϻ���
   @RequestMapping(value="/admin/board/list", method=RequestMethod.GET)
   public ModelAndView showBoardList(@RequestParam(value="currentPage", defaultValue="1" , required=false) int currentPage, HttpServletRequest request) {
      System.out.println("showBoardList ȣ����!!!");
	   List boardList=boardService.selectAll();
      ModelAndView mav=new ModelAndView("Javablog/list");
      pager.init(request, boardList.size());
      mav.addObject("boardList", boardList);
      mav.addObject("pager", pager);
      System.out.println("showBoardList ���� �Ϸ�!!!");
      return mav;
   }      

 //�Խù� 1�� �󼼺���
   @RequestMapping(value="/admin/board/detail", method=RequestMethod.GET)
   public ModelAndView detail(int board_id) {
     System.out.println("�Ѱ��� board_id "+board_id);
      Board board=boardService.select(board_id);
      ModelAndView mav=new ModelAndView();
      mav.setViewName("Javablog/detail");
      mav.addObject("board", board);
      return mav;
   }            
   //�Խù� ����
   @RequestMapping(value="/admin/board/edit", method=RequestMethod.POST)
   public ModelAndView edit(Board board) {
      boardService.update(board);
      ModelAndView mav=new ModelAndView();
      mav.setViewName("admin/board/detail");
      mav.addObject("board", board);
      return mav;
   }
   //�Խù� ����
   @RequestMapping(value="/admin/board/delete", method=RequestMethod.GET)
   public String del(int board_id) {
      boardService.delete(board_id);
      return "redirect:/admin/board/list";
   }
   
  //�Խù� �ۼ�
   @RequestMapping(value="/admin/board/write", method=RequestMethod.POST)
   public String regist(Board board) {
      boardService.insert(board);
     return "redirect:/admin/board/list";
   }


}









