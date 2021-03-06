package ch.m837.zombieInvasion.entities.module.modules;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import com.badlogic.gdx.math.Vector2;

import ch.m837.zombieInvasion.Config;
import ch.m837.zombieInvasion.World;
import ch.m837.zombieInvasion.entities.dataHandling.DataType;
import ch.m837.zombieInvasion.entities.module.Module;
import ch.m837.zombieInvasion.entities.module.RenderableModul;

public class SimpleImageRenderModule extends Module implements RenderableModul {
  private final Image imageToRender;

  public SimpleImageRenderModule(String entityID, Image imageToRender) {
    super(entityID);
    this.imageToRender = imageToRender;
  }

  /**
   * get the position data from the entity, transform it to world coordinates and render g
   * 
   * @param gc
   * @param sbg
   * @param g
   */
  @Override
  public void RENDER(GameContainer gc, StateBasedGame sbg, Graphics g) {
    World.getEntityHandler().getDataFrom(getEntityID(), DataType.POSITION)
        .ifPresent(positionData -> {
          Vector2 worldPosition = ((Vector2) positionData).scl(Config.B2PIX); // transform to world
                                                                              // coordinates
          g.drawImage(imageToRender, worldPosition.x - imageToRender.getWidth() / 2,
              worldPosition.y - imageToRender.getHeight() / 2);
        });
  }

  @Override
  public Object getData(DataType dataType) {
    // TODO Auto-generated method stub
    return null;
  }

}
