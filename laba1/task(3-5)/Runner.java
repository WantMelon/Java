import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.lang.NumberFormatException;

public class Runner {
	private static final String DEFAULT_ENCODING = "KOI8-R";
	private static String encoding = null;
	private static BufferedWriter writer = null;
	public static void out(String str) throws IOException {
		if(writer == null) {
			if(encoding == null) {
				encoding = DEFAULT_ENCODING;
			}
			writer = new BufferedWriter(new OutputStreamWriter(System.out, encoding));
		}
		writer.write(str);
		writer.flush();
	}
	public static void main(String args[]) throws IOException {
		try {
			if(args.length > 0) {
				int start = 0;
				if("-encoding".equals(args[0])) {
					if(args.length > 1) {
						encoding = args[1];
						if(args.length > 2) {
							start = 2;
						} else {
							out("��������� ������� � ������� ������������������ �������\n");
							out("����, �������� ����������� �������� � ��������.\n\n");
							out("�������������: java Runner [-encoding <encoding>] <numbers>\n\n");
							out("���:\n\n");
							out("\t-encoding <encoding>  ��������� ��������, ������������\n");
							out("\t                      ��� ������ � �������\n\n");
							out("\t<numbers>             ������������������ ����� �����\n");
							out("\t                      � ��������� �� 1 �� 32. ������\n");
							out("\t                      ����� - ��� ���������� �����\n");
							out("\t                      ����� � ������� ��������\n\n");
							return;
						}
					} else {
						out("too few parameters, try to run program without\n");
						out("parameters to get help.\n\n");
						return;
					}
				}
				try {
					for(int i = start; i < args.length; i++) {
						int n = Integer.parseInt(args[i]);
						if(1 <= n && n <= 32) {
							char letter = (char)('�' + n - 1);
							out(String.valueOf(letter));
						} else {
							throw new NumberFormatException();
						}
					}
				} catch(NumberFormatException e) {
					out("Incorrect number. Run class without parameters to get help.\n\n");
					out("������������ �����. ��������� ����� � ����������\n");
					out("-encoding <��������� �������> � ��� ������ ����������,\n");
					out("����� �������� �������\n\n");
				}
			} else {
				out("Program write to the console sequence of the Russian\n");
				out("letters which have been set by serial numbers in the\n");
				out("alphabet.\n\n");
				out("Usage: java Runner [-encoding <encoding>] <numbers>\n\n");
				out("where:\n\n");
				out("\t-encoding <encoding>  Specify character encoding\n");
				out("\t                      used by console output\n\n");
				out("\t<numbers>             Sequence of integer numbers in\n");
				out("\t                      the range from 1 to 32. Each\n");
				out("\t                      number is a serial number of a\n");
				out("\t                      letter in the Russian alphabet\n\n");
			}
		} catch(IOException e) {
			System.err.println("specified encoding is not supported");
		}
	}
}