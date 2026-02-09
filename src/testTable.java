import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

public class testTable {
    public static void main(String[] args) {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);

        table.addCell("Floor ID");
        table.addCell("Total Spots");
        table.addCell("Occupied Spots");
        table.addCell("Available Spots");
        table.addCell("Rate");

        table.addCell("Level 1");
        table.addCell("50");
        table.addCell("20");
        table.addCell("30");
        table.addCell("$5.00");

        table.addCell("Level 1");
        table.addCell("50");
        table.addCell("20");
        table.addCell("30");
        table.addCell("$5.00");

        System.out.println(table.render());
    }
}