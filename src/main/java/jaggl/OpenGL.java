/* OpenGL - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package jaggl;

import java.awt.Canvas;
import java.util.Hashtable;

public class OpenGL {
    private static final Hashtable<Thread, OpenGL> associatedThreads = new Hashtable<>();
    long peer;
    private Hashtable<String, String> aHashtable1747;
    private Thread threadPeer;

    public static native void glEnable(int i);

    public static native void glDisable(int i);

    public static native void glCullFace(int i);

    public static native void glPushAttrib(int i);

    public static native void glPopAttrib();

    public static native void glShadeModel(int i);

    public static native void glHint(int i, int i_11_);

    public static native void glFinish();

    public static native void glFlush();

    public static native void glClear(int i);

    public static native void glClearColor(float f, float f_12_, float f_13_, float f_14_);

    public static native void glClearDepth(float f);

    public static native void glDepthFunc(int i);

    public static native void glDepthMask(boolean bool);

    public static native void glDepthRange(float f, float f_15_);

    public static native void glAlphaFunc(int i, float f);

    public static native void glColorMask(boolean bool, boolean bool_16_, boolean bool_17_, boolean bool_18_);

    public static native void glReadBuffer(int i);

    public static native void glDrawBuffer(int i);

    public static native void glDrawBuffersARB(int i, int[] is, int i_19_);

    public static native void glMatrixMode(int i);

    public static native void glPushMatrix();

    public static native void glPopMatrix();

    public static native void glLoadIdentity();

    public static native void glOrtho(double d, double d_20_, double d_21_, double d_22_, double d_23_, double d_24_);

    public static native void glFrustum(double d, double d_25_, double d_26_, double d_27_, double d_28_, double d_29_);

    public static native void glTranslatef(float f, float f_30_, float f_31_);

    public static native void glRotatef(float f, float f_32_, float f_33_, float f_34_);

    public static native void glScalef(float f, float f_35_, float f_36_);

    public static native void glLoadMatrixf(float[] fs, int i);

    public static native void glMultMatrixf(float[] fs, int i);

    public static native void glViewport(int i, int i_37_, int i_38_, int i_39_);

    public static native void glScissor(int i, int i_40_, int i_41_, int i_42_);

    public static native int glGenLists(int i);

    public static native void glDeleteLists(int i, int i_43_);

    public static native void glNewList(int i, int i_44_);

    public static native void glEndList();

    public static native void glCallList(int i);

    public static native void glBegin(int i);

    public static native void glVertex2i(int i, int i_45_);

    public static native void glVertex2f(float f, float f_46_);

    public static native void glVertex3f(float f, float f_47_, float f_48_);

    public static native void glNormal3f(float f, float f_49_, float f_50_);

    public static native void glColor3f(float f, float f_51_, float f_52_);

    public static native void glColor4f(float f, float f_53_, float f_54_, float f_55_);

    public static native void glColor3ub(byte i, byte i_56_, byte i_57_);

    public static native void glColor4ub(byte i, byte i_58_, byte i_59_, byte i_60_);

    public static native void glTexCoord2i(int i, int i_61_);

    public static native void glTexCoord3i(int i, int i_62_, int i_63_);

    public static native void glTexCoord2f(float f, float f_64_);

    public static native void glTexCoord3f(float f, float f_65_, float f_66_);

    public static native void glMultiTexCoord2i(int i, int i_67_, int i_68_);

    public static native void glMultiTexCoord3i(int i, int i_69_, int i_70_, int i_71_);

    public static native void glMultiTexCoord2f(int i, float f, float f_72_);

    public static native void glRasterPos2i(int i, int i_73_);

    public static native void glEnd();

    public static native void glEnableClientState(int i);

    public static native void glDisableClientState(int i);

    public static native void glClientActiveTexture(int i);

    public static native void glVertexPointer(int i, int i_74_, int i_75_, long l);

    public static native void glNormalPointer(int i, int i_76_, long l);

    public static native void glColorPointer(int i, int i_77_, int i_78_, long l);

    public static native void glTexCoordPointer(int i, int i_79_, int i_80_, long l);

    public static native void glVertexAttribPointer(int i, int i_81_, int i_82_, boolean bool, int i_83_, long l);

    public static native void glEnableVertexAttribArray(int i);

    public static native void glDisableVertexAttribArray(int i);

    public static native void glBindAttribLocation(int i, int i_84_, String string);

    public static native int glGetAttribLocation(int i, String string);

    public static native void glGenBuffersARB(int i, int[] is, int i_85_);

    public static native void glBindBufferARB(int i, int i_86_);

    public static native void glBufferDataARBa(int i, int i_87_, long l, int i_88_);

    public static native void glBufferDataARBub(int i, int i_89_, byte[] is, int i_90_, int i_91_);

    public static native void glBufferSubDataARBa(int i, int i_92_, int i_93_, long l);

    public static native void glBufferSubDataARBub(int i, int i_94_, int i_95_, byte[] is, int i_96_);

    public static native long glMapBufferARB(int i, int i_97_);

    public static native boolean glUnmapBufferARB(int i);

    public static native void glDeleteBuffersARB(int i, int[] is, int i_98_);

    public static native void glLineWidth(float f);

    public static native void glPointSize(float f);

    public static native void glPolygonMode(int i, int i_99_);

    public static native void glDrawArrays(int i, int i_100_, int i_101_);

    public static native void glDrawElements(int i, int i_102_, int i_103_, long l);

    public static native void glGenTextures(int i, int[] is, int i_104_);

    public static native void glDeleteTextures(int i, int[] is, int i_105_);

    public static native void glActiveTexture(int i);

    public static native void glBindTexture(int i, int i_106_);

    public static native void glTexEnvi(int i, int i_107_, int i_108_);

    public static native void glTexEnvf(int i, int i_109_, float f);

    public static native void glTexEnvfv(int i, int i_110_, float[] fs, int i_111_);

    public static native void glTexGeni(int i, int i_112_, int i_113_);

    public static native void glTexGenfv(int i, int i_114_, float[] fs, int i_115_);

    public static native void glTexParameterf(int i, int i_116_, float f);

    public static native void glTexParameteri(int i, int i_117_, int i_118_);

    public static native void glGetTexImagei(int i, int i_119_, int i_120_, int i_121_, int[] is, int i_122_);

    public static native void glGetTexImageub(int i, int i_123_, int i_124_, int i_125_, byte[] is, int i_126_);

    public static native float glGetTexLevelParameterfv(int i, int i_127_, int i_128_);

    public static native int glGetTexLevelParameteriv(int i, int i_129_, int i_130_);

    public static native void glGetTexImage(int i, int i_131_, int i_132_, int i_133_, byte[] is);

    public static native void glTexImage1Dub(int i, int i_134_, int i_135_, int i_136_, int i_137_, int i_138_, int i_139_, byte[] is, int i_140_);

    public static native void glCopyTexImage2D(int i, int i_141_, int i_142_, int i_143_, int i_144_, int i_145_, int i_146_, int i_147_);

    public static native void glCopyTexSubImage2D(int i, int i_148_, int i_149_, int i_150_, int i_151_, int i_152_, int i_153_, int i_154_);

    public static native void glTexImage2Di(int i, int i_155_, int i_156_, int i_157_, int i_158_, int i_159_, int i_160_, int i_161_, int[] is, int i_162_);

    public static native void glTexImage2Df(int i, int i_163_, int i_164_, int i_165_, int i_166_, int i_167_, int i_168_, int i_169_, float[] fs, int i_170_);

    public static native void glTexImage2Dub(int i, int i_171_, int i_172_, int i_173_, int i_174_, int i_175_, int i_176_, int i_177_, byte[] is, int i_178_);

    public static native void glTexSubImage2Di(int i, int i_179_, int i_180_, int i_181_, int i_182_, int i_183_, int i_184_, int i_185_, int[] is, int i_186_);

    public static native void glTexSubImage2Df(int i, int i_187_, int i_188_, int i_189_, int i_190_, int i_191_, int i_192_, int i_193_, float[] fs, int i_194_);

    public static native void glTexSubImage2Dub(int i, int i_195_, int i_196_, int i_197_, int i_198_, int i_199_, int i_200_, int i_201_, byte[] is, int i_202_);

    public static native void glCopyTexSubImage3D(int i, int i_203_, int i_204_, int i_205_, int i_206_, int i_207_, int i_208_, int i_209_, int i_210_);

    public static native void glTexImage3Dub(int i, int i_211_, int i_212_, int i_213_, int i_214_, int i_215_, int i_216_, int i_217_, int i_218_, byte[] is, int i_219_);

    public static native void glCompressedTexImage2Dub(int i, int i_220_, int i_221_, int i_222_, int i_223_, int i_224_, int i_225_, byte[] is, int i_226_);

    public static native void glCopyPixels(int i, int i_227_, int i_228_, int i_229_, int i_230_);

    public static native void glReadPixelsi(int i, int i_231_, int i_232_, int i_233_, int i_234_, int i_235_, int[] is, int i_236_);

    public static native void glReadPixelsub(int i, int i_237_, int i_238_, int i_239_, int i_240_, int i_241_, byte[] is, int i_242_);

    public static native void glDrawPixelsi(int i, int i_243_, int i_244_, int i_245_, int[] is, int i_246_);

    public static native void glDrawPixelsub(int i, int i_247_, int i_248_, int i_249_, byte[] is, int i_250_);

    public static native void glPixelZoom(float f, float f_251_);

    public static native void glPixelStorei(int i, int i_252_);

    public static native void glPixelTransferf(int i, float f);

    public static native void glColorMaterial(int i, int i_253_);

    public static native void glLightf(int i, int i_254_, float f);

    public static native void glLightfv(int i, int i_255_, float[] fs, int i_256_);

    public static native void glLightModelfv(int i, float[] fs, int i_257_);

    public static native void glMaterialfv(int i, int i_258_, float[] fs, int i_259_);

    public static native void glFogi(int i, int i_260_);

    public static native void glFogf(int i, float f);

    public static native void glFogfv(int i, float[] fs, int i_261_);

    public static native void glBlendFunc(int i, int i_262_);

    public static native void glBlendFuncSeparate(int i, int i_263_, int i_264_, int i_265_);

    public static native void glBlendColor(float f, float f_266_, float f_267_, float f_268_);

    public static native void glGenFramebuffersEXT(int i, int[] is, int i_269_);

    public static native void glDeleteFramebuffersEXT(int i, int[] is, int i_270_);

    public static native void glBindFramebufferEXT(int i, int i_271_);

    public static native void glFramebufferTexture2DEXT(int i, int i_272_, int i_273_, int i_274_, int i_275_);

    public static native void glFramebufferTexture3DEXT(int i, int i_276_, int i_277_, int i_278_, int i_279_, int i_280_);

    public static native void glFramebufferRenderbufferEXT(int i, int i_281_, int i_282_, int i_283_);

    public static native int glCheckFramebufferStatusEXT(int i);

    public static native void glBlitFramebufferEXT(int i, int i_284_, int i_285_, int i_286_, int i_287_, int i_288_, int i_289_, int i_290_, int i_291_, int i_292_);

    public static native void glGenerateMipmapEXT(int i);

    public static native void glGenRenderbuffersEXT(int i, int[] is, int i_293_);

    public static native void glDeleteRenderbuffersEXT(int i, int[] is, int i_294_);

    public static native void glBindRenderbufferEXT(int i, int i_295_);

    public static native void glRenderbufferStorageEXT(int i, int i_296_, int i_297_, int i_298_);

    public static native void glRenderbufferStorageMultisampleEXT(int i, int i_299_, int i_300_, int i_301_, int i_302_);

    public static native int glGenProgramARB();

    public static native void glDeleteProgramARB(int i);

    public static native void glBindProgramARB(int i, int i_303_);

    public static native void glProgramStringARB(int i, int i_304_, String string);

    public static native void glProgramRawARB(int i, int i_305_, byte[] is);

    public static native void glProgramLocalParameter4fARB(int i, int i_306_, float f, float f_307_, float f_308_, float f_309_);

    public static native void glProgramLocalParameter4fvARB(int i, int i_310_, float[] fs, int i_311_);

    public static native void glGetProgramivARB(int i, int i_312_, int[] is, int i_313_);

    public static native int glCreateProgram();

    public static native int glCreateShader(int i);

    public static native void glDeleteProgram(int i);

    public static native void glDeleteShader(int i);

    public static native void glShaderSource(int i, String string);

    public static native void glCompileShader(int i);

    public static native void glAttachShader(int i, int i_314_);

    public static native void glDetachShader(int i, int i_315_);

    public static native void glLinkProgram(int i);

    public static native void glUseProgram(int i);

    public static native int glGetUniformLocation(int i, String string);

    public static native void glUniform1i(int i, int i_316_);

    public static native void glUniform1f(int i, float f);

    public static native void glUniform2f(int i, float f, float f_317_);

    public static native void glUniform3f(int i, float f, float f_318_, float f_319_);

    public static native void glUniform4f(int i, float f, float f_320_, float f_321_, float f_322_);

    public static native void glUniform1fv(int i, int i_323_, float[] fs, int i_324_);

    public static native void glUniform2fv(int i, int i_325_, float[] fs, int i_326_);

    public static native void glUniform3fv(int i, int i_327_, float[] fs, int i_328_);

    public static native void glUniform4fv(int i, int i_329_, float[] fs, int i_330_);

    public static native void glUniformMatrix2fv(int i, int i_331_, boolean bool, float[] fs, int i_332_);

    public static native void glUniformMatrix3fv(int i, int i_333_, boolean bool, float[] fs, int i_334_);

    public static native void glUniformMatrix4fv(int i, int i_335_, boolean bool, float[] fs, int i_336_);

    public static native void glGetProgramiv(int i, int i_337_, int[] is, int i_338_);

    public static native void glGetShaderiv(int i, int i_339_, int[] is, int i_340_);

    public static native void glGetProgramInfoLog(int i, int i_341_, int[] is, int i_342_, byte[] is_343_, int i_344_);

    public static native void glGetShaderInfoLog(int i, int i_345_, int[] is, int i_346_, byte[] is_347_, int i_348_);

    public static native int glGetError();

    public static native String glGetString(int i);

    public static native void glGetFloatv(int i, float[] fs, int i_349_);

    public static native void glGetIntegerv(int i, int[] is, int i_350_);

    public static native void glStencilFunc(int i, int i_351_, int i_352_);

    public static native void glStencilOp(int i, int i_353_, int i_354_);

    public native long init(Canvas canvas, int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_);

    public native boolean arePbuffersAvailable();

    public boolean supportsExtension(String extensionName) {
        if (aHashtable1747 == null) {
            aHashtable1747 = new Hashtable<>();
            String oglString = glGetString(7939);
            int charIndex = 0;
            while (true) {
                int oglWord = oglString.indexOf(' ', charIndex);
                if (oglWord == -1) {
                    break;
                }
                String oglWord2 = oglString.substring(charIndex, oglWord).trim();
                if (!oglWord2.isEmpty()) {
                    aHashtable1747.put(oglWord2, oglWord2);
                };
                charIndex = 1 + oglWord;
            }
            String string_8_ = oglString.substring(charIndex).trim();
            if (!string_8_.isEmpty()) {
                aHashtable1747.put(string_8_, string_8_);
            }
        }
        return aHashtable1747.containsKey(extensionName);
    }

    public synchronized boolean method2570() {
        Thread thread = Thread.currentThread();
        if (attachPeer()) {
            OpenGL released = associatedThreads.put(thread, this);
            if (released != null) {
                released.threadPeer = null;
            }
            threadPeer = thread;
            return true;
        }
        return false;
    }

    public synchronized boolean method2571() {
        if (threadPeer != Thread.currentThread()) {
            return false;
        }
        detachPeer();
        associatedThreads.remove(threadPeer);
        threadPeer = null;
        return true;
    }

    private native boolean attachPeer();

    private native void detachPeer();

    public native long prepareSurface(Canvas canvas);

    public native void surfaceResized(long l);

    public native void releaseSurface(Canvas canvas, long l);

    public native boolean setSurface(long l);

    public native long createPbuffer(int i, int i_10_);

    public native void releasePbuffer(long l);

    public native void setPbuffer(long l);

    public native void swapBuffers(long l);

    public native void setSwapInterval(int i);

    public native void release();

}