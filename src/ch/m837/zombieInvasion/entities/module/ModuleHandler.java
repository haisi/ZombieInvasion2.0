package ch.m837.zombieInvasion.entities.module;

import java.util.ArrayList;

import ch.m837.zombieInvasion.World;
import ch.m837.zombieInvasion.entities.module.modules.MovementModule;
import ch.m837.zombieInvasion.entities.module.modules.PhysicsModule;
import ch.m837.zombieInvasion.entities.module.modules.SelectionModule;
import ch.m837.zombieInvasion.entities.module.modules.SimpleImageRenderModule;

public class ModuleHandler {
  /*
   * Needs to be expanded for each new Module
   * 
   */
  private ArrayList<SelectionModule> selectionModules = new ArrayList<>();
  private ArrayList<PhysicsModule> physicsModules = new ArrayList<>();
  private ArrayList<SimpleImageRenderModule> simpleImageRenderModules = new ArrayList<>();
  private ArrayList<MovementModule> movementModules = new ArrayList<>();

  public void addModules(Module... modules) {
    for (int i = 0; i < modules.length; i++) {
      Module module = modules[i];
      World.getEntityHandler().addModulToEntity(module);

      /*
       * Needs to be expanded for each new Module
       * 
       */
      if (module instanceof SelectionModule) {
        selectionModules.add((SelectionModule) module);
      } else if (module instanceof PhysicsModule) {
        physicsModules.add((PhysicsModule) module);
      } else if (module instanceof SimpleImageRenderModule) {
        simpleImageRenderModules.add((SimpleImageRenderModule) module);
      } else if (module instanceof MovementModule) {
        movementModules.add((MovementModule) module);
      }
    }

  }



  /*
   * Needs to be expanded for each new Module
   * 
   */
  public ArrayList<Module> getAllModules() {
    ArrayList<Module> allModules = new ArrayList<>();
    allModules.addAll(selectionModules);
    allModules.addAll(physicsModules);
    allModules.addAll(simpleImageRenderModules);
    allModules.addAll(movementModules);
    return allModules;
  }


  public ArrayList<PhysicsModule> getPhysicsModules() {
    return physicsModules;
  }

  public ArrayList<SelectionModule> getSelectionModules() {
    return selectionModules;
  }

  public ArrayList<SimpleImageRenderModule> getSimpleImageRenderModules() {
    return simpleImageRenderModules;
  }

  public ArrayList<MovementModule> getMovementModules() {
    return movementModules;
  }
}
