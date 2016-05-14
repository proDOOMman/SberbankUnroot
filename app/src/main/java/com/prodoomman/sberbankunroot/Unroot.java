package com.prodoomman.sberbankunroot;

import android.content.pm.PackageInfo;

import java.lang.reflect.Method;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findClass;

public class Unroot implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if(!lpparam.packageName.startsWith("ru.sberbankmobile")) {
            return;
        }

        try {

            Class<?> rootDetector = findClass("com.kavsdk.rootdetector.RootDetector", lpparam.classLoader);

            try {

                XposedHelpers.findAndHookMethod(rootDetector, "checkRoot", new XC_MethodReplacement() {

                    @Override
                    protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                        return false;
                    }
                });
            } catch (Exception e) {
                XposedBridge.log(e);
            }

            try {
                XposedHelpers.findAndHookMethod(rootDetector, "isRoot", new XC_MethodReplacement() {

                    @Override
                    protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                        return false;
                    }
                });
            } catch (Exception e) {
                XposedBridge.log(e);
            }

        }
        catch(XposedHelpers.ClassNotFoundError e) {
            XposedBridge.log(e);
        }

        try {

            Class<?> obfuscatedSheet = findClass("ru.sberbank.kavsdk.e.a", lpparam.classLoader);

            try {

                XposedHelpers.findAndHookMethod(obfuscatedSheet, "b", new XC_MethodReplacement() {

                    @Override
                    protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                        return false;
                    }
                });
            } catch (Exception e) {
                XposedBridge.log(e);
            }

            try {

                XposedHelpers.findAndHookMethod(obfuscatedSheet, "d", new XC_MethodReplacement() {

                    @Override
                    protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                        return false;
                    }
                });
            } catch (Exception e) {
                XposedBridge.log(e);
            }

            try {
                XposedHelpers.findAndHookMethod(obfuscatedSheet, "e", new XC_MethodReplacement() {

                    @Override
                    protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                        return false;
                    }
                });
            } catch (Exception e) {
                XposedBridge.log(e);
            }

        }
        catch(XposedHelpers.ClassNotFoundError e) {
            XposedBridge.log(e);
        }

    }

}
