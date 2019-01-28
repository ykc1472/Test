import java.util.ArrayList;
import java.util.Scanner;

import com.employee.biz.EmployeeBiz;
import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;
import com.employee.entity.Engineer;
import com.employee.entity.Sales;
import com.notice.biz.NoticeBiz;
import com.notice.entity.Notice;

public class ExecutivesManagementSystemTest {

	public static void main(String[] args) {
		Scanner scanN = new Scanner(System.in);
		Scanner scanS = new Scanner(System.in);
		int menu = 0;
		while (true) {
			System.out.println("*************************************************");
			System.out.println("[임직원 관리 시스템 메뉴]");
			System.out.println("*************************************************");
			System.out.println("1.전체 임직원 목록");
			System.out.println("2.임직원 정보 검색");
			System.out.println("3.임직원 정보 추가");
			System.out.println("4.임직원 정보 수정");
			System.out.println("5.임직원 정보 삭제");
			System.out.println("6.근태관리");
			System.out.println("7.공지사항 목록");
			System.out.println("8.공지사항 상세보기");
			System.out.println("9.공지사항 수정");
			System.out.println("10.공지사항 삭제");
			System.out.println("0.종료");
			System.out.println("*************************************************");
			System.out.print("메뉴 입력 => ");
			menu = scanN.nextInt();
			if (menu == 1) {
				EmployeeBiz service = new EmployeeBiz();
				ArrayList<Employee> list = service.selectAllEmployee();

				System.out.println("====================================================================");
				System.out.println("사번\t이름\t부서\t근무지\t연봉\t커미션\t입사일\t\t비고");
				System.out.println("--------------------------------------------------------------------");

				for (Employee i : list) {
					System.out.println(i.toString());
				}
				System.out.println("====================================================================");
			} else if (menu == 2) {
				System.out.println("*************************************************");
				System.out.println("[2. 임직원 정보검색]");
				System.out.println("*************************************************");
				System.out.println("1.사번 검색");
				System.out.println("2.이름 검색");
				System.out.println("3.부서 검색");
				System.out.println("4.근무지 검색");
				System.out.println("5.연봉 검색");
				System.out.println("*************************************************");
				System.out.print("메뉴 입력(1~5 사이 정수로 입력) => ");
				menu = scanN.nextInt();
				EmployeeBiz service = new EmployeeBiz();
				ArrayList<Employee> list = null;
				String searchWord = "";
				if (menu == 1) {
					System.out.print("검색할 사번을 입력하세요  => ");
				} else if (menu == 2) {
					System.out.print("검색할이름을 입력하세요  => ");
				} else if (menu == 3) {
					System.out.print("검색할  부서를 입력하세요(1. 영업, 2. 개발)  => ");
				} else if (menu == 4) {
					System.out.print("검색할 근무지를 입력하세요  => ");
				} else if (menu == 5) {
					System.out.print("검색할 연봉를 입력하세요  => ");
				}
				searchWord = scanS.nextLine();
				list = service.searchList(String.valueOf(menu), searchWord);
				System.out.println("====================================================================");
				System.out.println("사번\t이름\t부서\t근무지\t연봉\t커미션\t입사일\t\t비고");
				System.out.println("--------------------------------------------------------------------");

				for (Employee i : list) {
					System.out.println(i.toString());
				}
				System.out.println("====================================================================");

			} else if (menu == 3) {
				EmployeeBiz service = new EmployeeBiz();
				ArrayList<Employee> list = service.selectAllEmployee();
				int max = 0;
				for (Employee i : list) {
					if (max < i.getEmpno()) {
						max = i.getEmpno();
					}
				}
				System.out.println("사원번호[" + (max + 1) + "]를 생성하였습니다.");
				System.out.print("추가할 이름을 입력하세요 => ");
				String ename = scanS.next();
				System.out.print("추가할 부서를 입력하세요(1.영업 2.개발) => ");
				String dname = scanS.next();
				System.out.print("추가할 근무지를 입력하세요(서울, 부산, 인천) => ");
				String loc = scanS.next();
				System.out.print("추가할 연봉을 입력하세요 => ");
				scanN.nextLine();
				int sal = scanN.nextInt();
				System.out.println("추가할 입사일(예 : 2014-06-01)을 입력하세요");
				System.out.print("엔터를 치면 현재날짜로 입력됩니다. => ");
				scanS.nextLine();
				String hiredate = scanS.nextLine();
				if (dname.equals("1")) {
					service.employeeInsert(new Sales(max + 1, ename, hiredate, loc, sal, "근무"));
				} else if (dname.equals("2")) {
					service.employeeInsert(new Engineer(max + 1, ename, hiredate, loc, sal, "근무"));
				}

			} else if (menu == 4) {
				EmployeeBiz service = new EmployeeBiz();
				ArrayList<Employee> list = null;
				String searchWord = "";
				System.out.println("*************************************************");
				System.out.println("[4. 임직원 정보 수정]");
				System.out.println("*************************************************");
				System.out.print("수정할 사원번호를 입력하세요 => ");
				searchWord = scanS.nextLine();
				scanN.nextLine();

				list = service.searchList(String.valueOf(1), searchWord);
				Employee user = list.get(0);

				System.out.println("수정할 이름을 입력하세요.");
				System.out.print("Enter를 치면 이름은 수정하지 않습니다. => ");
				String ename = scanS.nextLine();
				System.out.print("수정할 부서를 입력하세요.(1.영업 2.개발) => ");
				String dname = scanS.nextLine();
				System.out.println("수정할 근무지를 입력하세요.");
				System.out.print("Enter를 치면 근무지는 수정하지 않습니다. => ");
				String loc = scanS.nextLine();

				System.out.println("수정할 연봉을 입력하세요.");
				System.out.print("Enter를 치면 연봉은 수정하지 않습니다. => ");
				String sal = scanS.nextLine();

				if (ename.equals("")) {
					ename = String.valueOf(user.getEname());
				}
				if (sal.equals("")) {
					sal = String.valueOf(user.getSal());
				}
				if (loc.equals("")) {
					loc = user.getLoc();
				}
				if (dname.equals("1")) {
					service.employeeUpdate(
							new Sales(user.getEmpno(), ename, user.getHiredate(), loc, Integer.parseInt(sal), "근무"));
				} else if (dname.equals("2")) {
					service.employeeUpdate(
							new Engineer(user.getEmpno(), ename, user.getHiredate(), loc, Integer.parseInt(sal), "근무"));
				}

			} else if (menu == 5) {
				EmployeeBiz service = new EmployeeBiz();
				System.out.println("*************************************************");
				System.out.println("[5. 임직원 정보 삭제]");
				System.out.println("*************************************************");
				System.out.print("수정할 사원번호를 입력하세요 => ");
				int empno = scanN.nextInt();
				service.employeeDelete(empno);
				System.out.println("*************************************************");

			} else if (menu == 6) {
				EmployeeBiz service = new EmployeeBiz();
				ArrayList<Employee> list = null;
				String searchWord = "";
				System.out.println("*************************************************");
				System.out.println("[6. 근태 관리]");
				System.out.println("*************************************************");
				System.out.print("변경할 사원번호를 입력하세요. => ");
				searchWord = scanS.nextLine();
				System.out.println("1. 외출 ");
				System.out.println("2. 출장 ");
				System.out.println("3. 휴가 ");
				System.out.println("4. 근무 ");
				System.out.println("--------------------------------------------------------------------");
				System.out.print("메뉴를 입력하세요(정수) => ");
				menu = scanN.nextInt();
				scanN.nextLine();
				
				list = service.searchList(String.valueOf(1), searchWord);
				Employee user = list.get(0);
				
				System.out.println("--------------------------------------------------------------------");

				String value = "근무";

				if (menu == 1) {
					value = "외출";
				} else if (menu == 2) {
					value = "출장";
				} else if (menu == 3) {
					value = "휴가";
				} else if (menu == 4) {
					value = "근무";
				}
				service.employeeService(Integer.parseInt(searchWord), value);
				System.out.println("*************************************************");
				System.out.println(user.getState() + "에서 " + value + "중으로 변경되었습니다.");
				System.out.println("*************************************************");

			} else if (menu == 7) {
				NoticeBiz service = new NoticeBiz();
				ArrayList<Notice> list = service.selectAllNotice();

				System.out.println("====================================================================");
				System.out.println("No\t제목\t\t\t\t작성자\t\t작성일자");
				System.out.println("--------------------------------------------------------------------");
				
				for(Notice i : list) {
					System.out.println(i.toString());
				}
				
			} else if (menu == 8) {
				NoticeBiz service = new NoticeBiz();
				System.out.print("공지 글 번호를 입력하세요 => ");
				String noticeNum = scanS.nextLine();
				Notice notice = service.selectDetailNotice(noticeNum);
				System.out.println("====================================================================");
				System.out.println("No\t제목\t\t\t\t작성자\t\t작성일자");
				System.out.println("--------------------------------------------------------------------");
				System.out.println(notice.toString());
				System.out.println("--------------------------------------------------------------------");
				System.out.println("\t"+notice.getContent());
				System.out.println("--------------------------------------------------------------------");
			
			} else if (menu == 9) {
				NoticeBiz service = new NoticeBiz();
				System.out.println("*************************************************");
				System.out.println("[9. 공지사항 수정]");
				System.out.println("*************************************************");
				System.out.print("수정할 할 공지 글번호를 입력하세요 => ");
				String noticeNum = scanS.nextLine();
				Notice notice = service.selectDetailNotice(noticeNum);
				System.out.println("1. 제목수정");
				System.out.println("2. 내용수정");
				System.out.println("3. 모두수정");
				System.out.print("메뉴를 입력하세요(정수) => ");
				int choice = scanN.nextInt();
				System.out.println("--------------------------------------------------------------------");
				if(choice == 1) {
					System.out.print("수정 할 제목 입력 => ");
					String title = scanS.nextLine();
					notice.setTitle(title);
					System.out.println("--------------------------------------------------------------------");
				}
				else if(choice == 2) {
					System.out.print("수정 할 내용 입력 => ");
					String content = scanS.nextLine();
					notice.setContent(content);
					System.out.println("--------------------------------------------------------------------");
				}
				else if(choice == 3) {
					System.out.print("수정 할 제목 입력 => ");
					String title = scanS.nextLine();
					notice.setTitle(title);
					System.out.println("--------------------------------------------------------------------");
					System.out.print("수정 할 내용 입력 => ");
					String content = scanS.nextLine();
					notice.setContent(content);
					System.out.println("--------------------------------------------------------------------");
				}
				service.noticeUpdate(notice);
				
				System.out.println("*************************************************");
				
			} else if (menu == 10) {
				NoticeBiz service = new NoticeBiz();
				System.out.println("*************************************************");
				System.out.println("[10. 공지사항 삭제]");
				System.out.println("*************************************************");
				System.out.print("식제 할 공지 글번호를 입력하세요 => ");
				String inputNum = scanS.nextLine();
				service.noticeDelete(inputNum);
				System.out.println("*************************************************");

			} else if (menu == 0) {
				break;
			}
		}
	}

}
