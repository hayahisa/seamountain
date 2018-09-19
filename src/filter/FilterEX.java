package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") //*:全てのファイルで
public class FilterEX implements Filter {
	private String encoding = "UTF-8";

	public FilterEX() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void destroy() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {
		// TODO 自動生成されたメソッド・スタブ
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		
		//doFilterより前に書いた処理は前処理、後に書いたのは後処理
		arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO 自動生成されたメソッド・スタブ

	}

}
