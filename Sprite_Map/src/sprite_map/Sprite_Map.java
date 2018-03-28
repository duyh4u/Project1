/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprite_map;

/**
 *
 * @author Hau Nguyen
 */
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
    
public class Sprite_Map {
    
    public static void join(String inputPath, String outputPath) throws IOException{
                int mapHeight = 2;
                int mapWidth = 2;
                
		//mở thư mục chứa các sprite & đưa sprite vào mảng
		File directory = new File(inputPath);
		File[] files = directory.listFiles(); 
		//đọc sprite lên để lấy chiều rộng cao để tạo spritemap
		BufferedImage sprite = ImageIO.read(files[0]);
		//int width = sprite.getWidth()*files.length;
                int width = sprite.getWidth()*mapWidth;
		int height = sprite.getHeight()*mapHeight;
		BufferedImage spritemap = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
		//vẽ sprite lên spritemap
		Graphics2D g2d = spritemap.createGraphics();
		int x = 0; // vị trí bắt đầu 1 sprite
                int y = sprite.getHeight();
                
                int row1 = 0;
                int row2 = 0;
                
		for (File file:files){
                    sprite = ImageIO.read(file);
                        if(row1 < mapWidth){
                            g2d.drawImage(sprite, null, x, 0);
                            x += sprite.getWidth();
                            row1++;
                            if(row1 == mapWidth){
                                x = 0;
                            }
                        }else if(row2 < mapWidth){
                            g2d.drawImage(sprite, null, x , y);
                            x += sprite.getWidth();
                            row2++;
                        }
		}		
	//ghi spritemap ra ổ cứng
		ImageIO.write(spritemap, "png", new File(outputPath));
	}
    public static void main(String[] args) {
        try{
            Sprite_Map.join("D:\\Spritemap", "D:\\SpriteMap\\sprite_map.png");
        }catch(IOException ex){
            System.err.println(ex);}        
    }      
}
